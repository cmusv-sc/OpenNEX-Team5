import uuid
import datetime
import time
import random
import sys
import requests
import json

def strTimeProp(start, end, format, prop):
	stime = time.mktime(time.strptime(start, format))
	etime = time.mktime(time.strptime(end, format))
	ptime = stime + prop * (etime - stime)
	return time.strftime(format, time.localtime(ptime))

def randomDate(start, end, prop):
	return strTimeProp(start, end, '%m/%d/%Y %I:%M %p', prop)

def randomQuote():
	r = requests.get('http://api.icndb.com/jokes/random')
	if r.status_code == 200:
		j = json.loads(r.text)
		quote = str(j["value"]["joke"])
		return quote
	else:
		return randomQuote()

def createWorkflow(wfid, uid, ts, text):
	workflow = {}
	workflow["registryId"] = "0"
	workflow["workflowId"] = wfid
	workflow["versionNo"] = "1.0"
	workflow["registorId"] = uid
	workflow["registerTimeStamp"] = ts
	workflow["registerNote"] = text
	return workflow

if __name__ == "__main__":
	random.seed()
	# generate 1000 unique workflow IDs
	WF_COUNT=1000
	wf_ids=[]
	for i in range(0, WF_COUNT):
		aId = uuid.uuid4()
		wf_ids.append(str(aId))

	# generate 100 unique user IDs
	USER_COUNT=100
	user_ids=[]
	for i in range(0, USER_COUNT):
		aId = uuid.uuid4()
		user_ids.append(str(aId))

	startDate = "1/1/2010 12:00 PM"
	endDate = "5/1/2015 12:00 PM"

	wfs=[]
	for i in range(0, WF_COUNT):
		wf = createWorkflow(wf_ids[i], user_ids[random.randint(0,USER_COUNT-1)], randomDate(startDate, endDate, random.random()), randomQuote())
		wfs.append(wf)

	with open('workflows.json', 'w') as outfile:
		json.dump(wfs, outfile)
	
