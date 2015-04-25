CREATE TABLE IF NOT EXISTS `RecommendationDB`.`workflow` (
	workflow_id BIGINT NOT NULL AUTO_INCREMENT,
	title CHAR(40),
	PRIMARY KEY (workflow_id)
);

CREATE TABLE IF NOT EXISTS `RecommendationDB`.`workflowmeta` (
	workflowmeta_id CHAR(40),
	count int,
	PRIMARY KEY(workflowmeta_id)
);

CREATE TABLE IF NOT EXISTS `RecommendationDB`.`tag` (
	workflowmeta_id CHAR(40),
	tag CHAR(40)
);




