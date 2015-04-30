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
	return strTimeProp(start, end, '%Y-%m-%dT%H:%M:%S', prop)

def createWorkflowEntry(wfid, ts):
	workflow = {}
	workflow["id"] = "0"
	workflow["rootWorkflowId"] = wfid
	workflow["versionNo"] = "1.0"
	workflow["purpose"] = "byd"
	workflow["createTime"] = ts
	workflow["name"] = "abc"
	return workflow

def createLogFile(workflows, startTime, endTime):
	entries=[]
	ENTRY_COUNT=10000
	wfcount = len(workflows)
	for i in range(0,ENTRY_COUNT):
		wfid = workflows[random.randint(0,wfcount-1)]['workflowId']
		ts = randomDate(startTime, endTime, random.random())
		entry = createWorkflowEntry(wfid, ts)
		entries.append(entry)
	filename="logs/usage-logs-" + startTime.replace(":",".") + ".json"
	with open(filename, 'w') as outfile:
		json.dump(entries, outfile)

def createDayLogs(wfs, y, m, d):
	hours=["00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"]
	for i in range(0, len(hours)):
		h=hours[i]
		startDate= y + "-" + m + "-" + d + "T" + h + ":00:00"
		endDate= y + "-" + m + "-" + d + "T" + h + ":59:00"
		createLogFile(wfs, startDate, endDate)

if __name__ == "__main__":

	with open('workflows.json') as data_file:
		data = json.load(data_file)

	createDayLogs(data, "2015", "04", "25")
	createDayLogs(data, "2015", "04", "26")
	createDayLogs(data, "2015", "04", "27")
	createDayLogs(data, "2015", "04", "28")
	createDayLogs(data, "2015", "04", "29")
	createDayLogs(data, "2015", "04", "30")
	createDayLogs(data, "2015", "05", "01")


