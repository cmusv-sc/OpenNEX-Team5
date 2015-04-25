import uuid
import datetime
import random
import sys

args = sys.argv[1:]
if(len(args) < 1):
	print "usage: python tag-generator.py [idCount] (outdir)"
	sys.exit(1)

OUTDIR=""
if len(args) > 1:
	OUTDIR=args[1]


# generate X unique IDs
X=int(args[0])
ids=[]
for i in range(0, X):
	aId = uuid.uuid4()
	ids.append(str(aId))

# seed random generator
random.seed()

# generate Y lines of text
curTime = datetime.datetime.now().isoformat().replace(":", ".")
filename = OUTDIR + "tags-" + curTime + ".txt"
logFile = open(filename, 'w')

tags=[]
tags.append('weather')
tags.append('sea level')
tags.append('temperature')
tags.append('atmosphere')
tags.append('geography')
tags.append('geophysics')
tags.append('soil')
tags.append('ice')
tags.append('water')
tags.append('ecology')
tags.append('animals')
tags.append('tectonics')
tags.append('volcanoes')
tags.append('earthquakes')

for i in range(0,X):
	uid = ids[i]
	tagCount = random.randint(1,len(tags))
	tag=""
	for j in range(0,tagCount):
		tagIndex = random.randint(0,len(tags)-1)
		tag = tag + tags[tagIndex] + ","
	logFile.write(uid + "\t" + tag[:-1] + "\n")

print "tags generated"