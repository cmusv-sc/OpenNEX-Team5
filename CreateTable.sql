CREATE TABLE IF NOT EXISTS `RecommendationDB`.`workflow` (
	workflow_id BIGINT NOT NULL AUTO_INCREMENT,
	title CHAR(40),
	PRIMARY KEY (workflow_id)
);

CREATE TABLE IF NOT EXISTS `RecommendationDB`.`workflowmeta` (
	workflowmeta_id BIGINT NOT NULL AUTO_INCREMENT,
	workflow_id BIGINT,
	tag CHAR(40),
	count int,
	contributor CHAR(40),
	PRIMARY KEY(workflowmeta_id),
	CONSTRAINT fk_workflow_id FOREIGN KEY(workflow_id) REFERENCES 
	workflow(workflow_id) ON DELETE CASCADE ON UPDATE CASCADE
);




