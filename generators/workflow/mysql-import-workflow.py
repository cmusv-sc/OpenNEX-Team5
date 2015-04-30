import sys
import MySQLdb
import json

args = sys.argv[1:]
if(len(args) < 1):
	print "usage: python mysql-import-workflow.py workflows.json"
	sys.exit(1)

filename=args[0]

with open(filename) as data_file:
	data = json.load(data_file)

		# Connect to the database and create the tables
conn = MySQLdb.connect (host = "localhost", user = "root", passwd = "")
cursor = conn.cursor ()
cursor.execute ("DROP DATABASE IF EXISTS opennex")
cursor.execute ("CREATE DATABASE opennex")
cursor.execute ("USE opennex")
cursor.execute ("""
CREATE TABLE workflow_entry
(
  registryId     TEXT,
  workflowId     TEXT,
  versionNo      TEXT,
  registorId     TEXT,
  registerTimeStamp TEXT,
  registerNote   TEXT
  )
  """)

for i in range(0, len(data)):
	wf = data[i]
	rId = wf['registryId']
	wId = wf['workflowId']
	ver = wf['versionNo']
	regId = wf['registorId']
	ts = wf['registerTimeStamp']
	note = wf['registerNote']
	cursor.execute ("""INSERT INTO workflow_entry (registryId,workflowId,versionNo,registorId,registerTimeStamp,registerNote)
    	VALUES
    	(%s,%s,%s,%s,%s,%s)""", (rId, wId, ver, regId, ts, note))

#Commit the changes.
conn.commit()
cursor.close()
conn.close()