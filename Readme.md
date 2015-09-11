##To run

1) mvn clean package

2) java -jar target/regime-1.0-jar-with-dependencies.jar -config config/regime.conf.yaml --csv config/all_india_PO_list_without_APS_offices_ver2.csv for indexing

3) java -jar target/regime-searcher-1.0-jar-with-dependencies.jar -config target/regime-searcher--1.0-jar-with-dependencies.jar for searching

