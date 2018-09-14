package com.alstutor.studentrestapi

//import com.github.fakemongo.Fongo
import com.mongodb.MongoClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

@Configuration
class TestConfiguration: AbstractMongoConfiguration() {
    @Autowired
    lateinit var env: Environment

    override fun getDatabaseName() = env.getProperty("mongo.db.name", "test")

    override fun mongoClient(): MongoClient {
        logger.info("Creating Fongo fake mongo DB: $databaseName")
        //return Fongo(databaseName).mongo
        return MongoClient("192.168.0.2", 27017)
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(TestConfiguration::class.java)
    }
}