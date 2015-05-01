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
#cursor.execute ("DROP DATABASE IF EXISTS opennex")
#cursor.execute ("CREATE DATABASE opennex")
cursor.execute ("USE opennex")
cursor.execute ("""
CREATE TABLE IF NOT EXISTS workflow_entry
(
  registry_id     TEXT,
  workflow_id     TEXT,
  version_no      TEXT,
  registor_id     TEXT,
  register_time_stamp TEXT,
  register_note   TEXT
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
	cursor.execute ("""INSERT INTO workflow_entry (registry_id,workflow_id,version_no,registor_id,register_time_stamp,register_note)
    	VALUES
    	(%s,%s,%s,%s,%s,%s)""", (rId, wId, ver, regId, ts, note))

#Commit the changes.
conn.commit()
cursor.close()
conn.close()