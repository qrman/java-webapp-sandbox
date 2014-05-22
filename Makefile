build:
	mvn clean install

db-create:
	scripts/db-create.sh

db-drop:
	scripts/db-drop.sh

db-recreate:
	scripts/db-drop.sh
	scripts/db-create.sh