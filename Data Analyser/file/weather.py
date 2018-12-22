from pyspark import SparkConf, SparkContext
from pyspark.sql import Row, SparkSession
import mysql.connector

conf = SparkConf().setMaster("local[2]").setAppName("Piyush")
sc = SparkContext(conf=conf)
spark = SparkSession(sc)


def fetch_weather_data():
    conn = mysql.connector.connect(host='10.10.30.50', database='weatherdata', user='root', password='root')
    my_cursor = conn.cursor()
    my_cursor.execute("select * from dailystatus")
    rows = my_cursor.fetchall()
    my_cursor.execute(
        "select windspeedKmph from hoursdata where weatherId in (select weatherId from dailyStatus where city='mumbai' and date='2018-07-13')")
    windspeed_data = my_cursor.fetchall()
    # df = pd.DataFrame([[ij for ij in i] for i in rows])
    # df.rename(columns={0: 'date', 1: 'maxtempC', 2: 'maxtempF', 3: 'mintempC', 4: 'maxtemmpF'}, inplace=True)
    # print df
    my_cursor.close()
    del my_cursor
    conn.close()
    return rows, windspeed_data


def getRDD(weather_data):
    """ created two RDD Partitions """
    weather_RDD = sc.parallelize(weather_data, 2)
    if weather_RDD:
        return weather_RDD
    return weather_data


def get_total_data_count(weather_RDD):
    print("Total Number of data : {}".format(weather_RDD.count()))
    get_each_partition_detail(weather_RDD)


def get_each_partition_detail(weather_RDD):
    print("Number of Partition :: {}".format(weather_RDD.getNumPartitions()))

    """Data in each partition"""
    for index, data in enumerate(weather_RDD.glom().collect()):
        print("Number of data in partition {} : {}".format(index, len(data)))


def get_weather_data():
    weather_data, windspeed_data = fetch_weather_data()
    weather_RDD = getRDD(weather_data)
    if weather_RDD:
        get_total_data_count(weather_RDD)
    weather_rdd_schema = weather_RDD.map(lambda line: Row(weatherId=line[0],
                                                          city=line[1],
                                                          date=line[2],
                                                          maxtempC=line[3],
                                                          maxtempF=line[4],
                                                          mintempC=line[5],
                                                          minTempF=line[6]
                                                          )).toDF()
    return weather_rdd_schema, windspeed_data
