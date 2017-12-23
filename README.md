# Filter Isis 

A Spark implementation of an investigation to filter a large dataset of Twitter data for known (suspected) ISIL sympathizer's screen_names.

------------------------------

## How to Run

### Compile:

    mvn clean package


### Run Spark-submit job

    spark-submit
        --master yarn
        --class com.uncharted.FilterIsis
        --executor-memory 40G
        --executor-cores 4
        --num-executors 40
        target/extractIsilTweets-0.0.1.jar
        <hdfs input path>
        <hdfs output path>

n.b. set executor-cores, num-executors, executor-memory based on the resources available.