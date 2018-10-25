package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent.KinesisEventRecord;

public class LambdaFunctionHandler implements RequestHandler<KinesisEvent, Integer> {

    @Override
    public Integer handleRequest(KinesisEvent event, Context context) {

//    	KinesisProducerConfiguration config = new KinesisProducerConfiguration()
//    	        .setRecordMaxBufferedTime(3000)
//    	        .setMaxConnections(1)
//    	        .setRequestTimeout(60000)
//    	        .setRegion("us-west-1");

//    	final KinesisProducer kinesisProducer = new KinesisProducer(config);

    	//KinesisProducer kinesis = new KinesisProducer();
        context.getLogger().log("Input: " + event);

        for (KinesisEventRecord record : event.getRecords()) {
            String payload = new String(record.getKinesis().getData().array());
            context.getLogger().log("Payload: " + payload);
        }

        return event.getRecords().size();
    }
}
