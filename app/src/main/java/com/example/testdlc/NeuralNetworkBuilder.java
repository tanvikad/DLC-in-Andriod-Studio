package com.example.testdlc;
import com.qualcomm.qti.snpe.FloatTensor;
import com.qualcomm.qti.snpe.NeuralNetwork;
import com.qualcomm.qti.snpe.SNPE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import android.content.Context;
import android.app.Application;

public class NeuralNetworkBuilder {


    public boolean initializingModel(Context context, String modelName) {

        NeuralNetwork.Runtime runtime = NeuralNetwork.Runtime.valueOf("CPU");
        Application application = (Application)(context.getApplicationContext());
        System.out.println("Initializing model %s."+modelName);
//        String model_path_name = "/assets/super_resolution_sesr.opt.dlc";
//        InputStream modelData = application.getAssets().open(model_path_name);
        try {
            final SNPE.NeuralNetworkBuilder builder = new SNPE.NeuralNetworkBuilder(application)
                    // Allows selecting a runtime order for the network.
                    // In the example below use DSP and fall back, in order, to GPU then CPU
                    // depending on whether any of the runtimes is available.
//                .setRuntimeOrder(DSP, GPU, CPU)
                    .setRuntimeOrder(runtime)
                    // Loads a model from DLC file
                    .setModel(new File("/assets/super_resolution_sesr_opt.dlc"));
            final NeuralNetwork network = builder.build();
        } catch(IOException e) {
            System.out.println(e.getMessage()+ e);
        }


        return true;
    }
}
