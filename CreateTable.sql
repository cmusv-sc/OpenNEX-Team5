CREATE TABLE IF NOT EXISTS `RecommendationDB`.`workflow` (
	workflow_id BIGINT NOT NULL AUTO_INCREMENT,
	title CHAR(40),
	PRIMARY KEY (workflow_id)
);

CREATE TABLE IF NOT EXISTS `RecommendationDB`.`workflowmeta` (
	workflowmeta_id CHAR(40),
	count int,
	tag VARCHAR (200),
	PRIMARY KEY(workflowmeta_id)
);


CREATE TABLE IF NOT EXISTS `RecommendationDB`.`workflowentry` (
	registryId CHAR(40),
	workflowId CHAR(40),
	versionNo int,
	registorId CHAR(40),
	registerTimeStamp DATETIME,
	registerNote CHAR(40)
);



