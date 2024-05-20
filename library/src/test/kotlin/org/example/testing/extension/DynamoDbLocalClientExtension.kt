package org.example.testing.extension

import com.amazonaws.services.dynamodbv2.local.main.ServerRunner
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer
import io.kotest.core.listeners.AfterProjectListener
import io.kotest.core.listeners.BeforeProjectListener
import java.net.ServerSocket
import java.net.URI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

class DynamoDbLocalClientExtension : BeforeProjectListener, AfterProjectListener {

    companion object {
        lateinit var dynamoDbClient: DynamoDbClient
        lateinit var dynamoDbEnhancedClient: DynamoDbEnhancedClient
    }

    private lateinit var dynamoDbServer: DynamoDBProxyServer

    override suspend fun beforeProject() {
        println("Hello! Starting DynamoDB Project")

        val port = withContext(Dispatchers.IO) {
            ServerSocket(0, 0).use { it.localPort.toString() }
        }

        println("Start Init server")

        dynamoDbServer = ServerRunner
            .createServerFromCommandLineArgs(arrayOf("-inMemory", "-port", port))
        dynamoDbServer.start()

        println("Start Init client")

        dynamoDbClient = DynamoDbClient.builder()
            .endpointOverride(URI("http://localhost:$port"))
            .region(Region.US_WEST_2)
            .httpClient(UrlConnectionHttpClient.builder().build())
            .credentialsProvider(
                StaticCredentialsProvider
                    .create(AwsBasicCredentials.create("dummyKey", "dummySecret")),
            )
            .build()

        println("Start Init enhanced")

        dynamoDbEnhancedClient = DynamoDbEnhancedClient
            .builder()
            .dynamoDbClient(dynamoDbClient)
            .build()

        println("Hello! Started DynamoDB Project")
    }

    override suspend fun afterProject() {
        println("Hello! Finishing DynamoDB Project")
        dynamoDbClient.close()
        dynamoDbServer.stop()
        println("Hello! Finished DynamoDB Project")
    }
}
