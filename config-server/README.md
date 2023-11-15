create table properties(id integer not null auto_increment, CREATED_ON datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,APPLICATION varchar(255), PROFILE varchar(255), LABEL varchar(255), PROP_KEY varchar(255), VALUE varchar(255), primary key (id));
INSERT INTO properties (APPLICATION, PROFILE, LABEL, PROP_KEY, VALUE) VALUES
('spring-cloud-config-client', 'dev', 'latest', 'URL_A', 'https://client-urlA-dev.com'),
('spring-cloud-config-client', 'dev', 'latest', 'URL_B', 'https://client-urlB-dev.com'),
('spring-cloud-config-client', 'test', 'latest', 'URL_A', 'https://client-urlA-test.com'),
('spring-cloud-config-client2', 'dev', 'latest', 'URL_A', 'https://client2-urlA-dev.com'),
('spring-cloud-config-client2', 'test', 'latest', 'URL_A', 'https://client2-urlA-test.com');