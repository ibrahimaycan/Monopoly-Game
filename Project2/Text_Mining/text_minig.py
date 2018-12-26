import re,PyPDF2,shutil,urllib.request,glob,math,csv
from urllib.request import urlopen
from nltk.corpus import stopwords
import matplotlib.pyplot as plt
from wordcloud import WordCloud
stopwords = set(stopwords.words('english'))

allwords={}
tfidflist={}
words = {}  #if word is in the pdf then increase the value or word
hasFile = {}
tfidf = {}
totalwords=0
def getallwords(name):
    global allwords,totalwords
    try:
        file = open(name, "rb")
        pdfReader = PyPDF2.PdfFileReader(file)
        for i in range(pdfReader.getNumPages()):
            page = pdfReader.getPage(i).extractText().split()
            for j in page:
                temp = re.sub('[-/{}[()˘!@\'#_£$%+|?\]^=™ˆ.,:*"“;><&1234567890]', '', j).lower()
                #'[-/{}[()!@#£$.,:*"“;><&1234567890]'
                if temp not in stopwords and len(temp) > 2:
                    if temp in allwords:
                        allwords[temp] += 1
                        totalwords +=1
                    else:
                        allwords[temp] = 1
                        totalwords +=1

    except:
        pass

    file.close()
def getidfvalues(name):
    global  words, hasFile
    try:
        file = open(name, "rb")
        pdfReader = PyPDF2.PdfFileReader(file)
        for i in range(pdfReader.getNumPages()):
            page = pdfReader.getPage(i).extractText().split()
            for j in page:
                temp = re.sub('[-/{}[()˘!@\'#_£$%+|?\]^=™ˆ.,:*"“;><&1234567890]', '', j).lower()
                #'[-/{}[()!@#£$.,:*"“;><&1234567890]'
                if temp not in stopwords and len(temp) > 2:
                    if temp in hasFile and hasFile[temp] == 0:
                        words[temp] += 1
                        hasFile[temp] = 1
                    elif temp not in hasFile:
                        words[temp] = 1
                        hasFile[temp] = 1
    except:
        pass

    file.close()
    hasFile = dict.fromkeys(hasFile, 0)
html = urlopen("https://muratcanganiz.com/")
html_doc = html.read()
link ='https://muratcanganiz.com/'
match = re.findall(b'"(.*?\.pdf)"', html_doc)
links = []
titles= []
for i in range(len(match)):  # len(match)
    try:
        links.insert(i,link+match[i].decode('ASCII'))
        titles.insert(i,"pdf"+str(i)+".pdf")
    except:
        pass

for i in range(len(links)): #download part
    try:
        with urllib.request.urlopen(links[i]) as response, open(titles[i], 'wb') as out_file:
            shutil.copyfileobj(response, out_file)
    except:
        pass
fileList = glob.glob('*.pdf')
stopwords.update([" abstract", "introduction", "conclusions", "related", "work", "author", "university","incjasist"])
for file in range(len(fileList)):
    getallwords(fileList[file])
    getidfvalues(fileList[file])

for item in allwords:
    tfidflist[item]=(allwords[item]/totalwords)*math.log(len(fileList)/words[item],10)

sortedWords={}
sortedtfidfs={}

sortedWords = sorted(allwords.items(), key=lambda x: x[1], reverse=True)
sortedtfidfs =sorted(tfidflist.items(), key=lambda x: x[1], reverse=True)

tfFile = open('tf_list.csv', 'w')
for i in range(50):
    tfFile.write(str(sortedWords[i][0]) + '; ' + str(sortedWords[i][1]/totalwords) + '\n')
tfFile.close()

tfidfFile=open('tf_idf_list.csv','w')
for i in range(50):
    tfidfFile.write(str(sortedtfidfs[i][0]) + '; ' + str(sortedtfidfs[i][1]) + '\n' )
tfidfFile.close()

tf={}
tf_idf={}

with open('tf_idf_list.csv', newline='\n') as csvfile:
    reader = csv.reader(csvfile, delimiter=';')
    for row in reader:
        tf_idf[row[0]]=float(row[1])
csvfile.close()

with open('tf_list.csv', newline='\n') as csvfile:
    reader = csv.reader(csvfile, delimiter=';')
    for row in reader:
        tf[row[0]]=float(row[1])
csvfile.close()


tf_cloud = WordCloud(background_color='White', relative_scaling=0.7,width=1000,height=750).generate_from_frequencies(tf)
plt.imshow(tf_cloud)
plt.axis('off')
plt.savefig('tf_wordCloud.pdf', format='pdf')

tf_cloud = WordCloud(background_color='White', relative_scaling=0.7,width=1000,height=750).generate_from_frequencies(tf_idf)
plt.imshow(tf_cloud)
plt.axis('off')
plt.savefig('tf_idf_wordCloud.pdf', format='pdf')