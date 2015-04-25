#!/bin/bash
# runs the generator code

# jump to working directory
APP_PATH="/Users/cef/Developer/EverythingEvil/nex/opennex"
cd "$APP_PATH"

# create log folder if it doesn't exists
LOG_PATH="$APP_PATH/generated-logs/"
if [ ! -d "$LOG_PATH"  ]
then
	mkdir -p "$LOG_PATH"
fi

# run the generator scripts to output in logpath
python "$APP_PATH/generators/usage-generator.py" 100 10000 "$LOG_PATH"
python "$APP_PATH/generators/tag-generator.py" 100 "$LOG_PATH"
