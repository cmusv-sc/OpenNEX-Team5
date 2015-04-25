import uuid
import datetime
import random
import sys

args = sys.argv[1:]
if(len(args) < 2):
	print "usage: python usage-generator.py [idCount] [numOfLines] (outdir)"
	sys.exit(1)

OUTDIR=""
if len(args) > 2:
	OUTDIR=args[2]

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
filename = OUTDIR + "usage-log-" + curTime + ".log"
logFile = open(filename, 'w')

ENTRIES=int(args[1])

for i in range(0,ENTRIES):
	idIndex = random.randint(0,X-1)
	uid = ids[idIndex]
	logFile.write(uid + "\t" + datetime.datetime.now().isoformat() + "\n")

print "log generated"