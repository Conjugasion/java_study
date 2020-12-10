package HeapDump;

import com.sun.management.VMOption;
import sun.management.HotSpotDiagnostic;

import java.io.IOException;
import java.util.List;

/**
 * @author Lucas
 * @date 2019/5/29 13:36
 */
public class HotSpotDump {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*Thread t = new Thread(){
            public void run(){
                *//*MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
                List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
                for (MemoryPoolMXBean m : memoryPoolMXBeans) {
                    System.out.println("Name:" + m.getName() + ", MemoryManagerNames: " + m.getMemoryManagerNames() + ", Type: " + m.getType() + ", Usage: " + m.getUsage() + ", CollectionUsage: " + m.getCollectionUsage() + ", PeakUsage: " + m.getPeakUsage() );
                }*//*
                HotSpotDiagnostic diagnostic = new HotSpotDiagnostic();
                //System.out.println("ObjectName: " + diagnostic.getObjectName().toString());
                System.out.println("-------------");
                List<VMOption> vmOptionList = diagnostic.getDiagnosticOptions();
                for (VMOption v : vmOptionList) {
                    System.out.println(v.toString());
                }
                System.out.println("--------------");
                try {
                    diagnostic.dumpHeap("mydump.hprof", true);
                    System.out.println("dump over");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        t.join();*/
        HotSpotDiagnostic hotSpotDiagnostic = new HotSpotDiagnostic();
        List<VMOption> vmOptionList = hotSpotDiagnostic.getDiagnosticOptions();
        for (VMOption v:vmOptionList) {
            System.out.println(v.toString());
        }
        hotSpotDiagnostic.dumpHeap("dump.hprof", true);
    }
}
