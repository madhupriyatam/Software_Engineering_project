/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author pvmad
 */
public class newgraph {
    
    private static String start = null ;
    private static String end;//= "C" ;
    //private static int duration = 0;
    public static HashMap<String, Integer> durationmap = new HashMap<String, Integer>();
    public static HashMap<Integer, String> hmap = new HashMap<Integer, String>();
    public static HashMap<String, Integer> secmp = new HashMap<String, Integer>();
//    public static final Queue<Integer> queue = new Queue<Integer>();
    static boolean checkcycle = false;

    private static String parse_final_result(String answer)
    
    {
          //System.out.println(answer);
        String[] part_one = answer.split("DURATION_SPLIT");
        String result_output = "";
        int a[] = new int[part_one.length];
        int count = 0;
        String temp = "";
        //String converta = null;
        for(String s: part_one)
        {
             a[count] = Integer.parseInt(s.split("::")[1]);
              // System.out.println(a[count]);
              count++;
        }
        
        for (int i = 0; i < part_one.length; i++) 
        {
            for (int j = i + 1; j < part_one.length; j++) 
            {
                //System.out.println(part_one[i] + " : : " + part_one[j]);
                if (Integer.parseInt(part_one[i].split("::")[1]) < Integer.parseInt(part_one[j].split("::")[1])) 
                {
                    temp = part_one[i];
                    part_one[i] = part_one[j];
                    part_one[j] = temp;
                }
            }
        }
        
        
      // System.out.println(part_one.length);
       
        //for (int i =0; i < part_one.length ; i++)
    //{
             for(String s_new : part_one)
             {
                 
             //int res = isSubstring(a[i], s_new);
             //System.out.println(s_new + "  " + a[i]);
             //if(res != -1)
             //{
               //  System.out.println(s_new);
             result_output = result_output + s_new + "\r\n";
             //}
             //System.out.println(result_output);
             
             }

    //}
        //hmap.clear();
        //durationmap.clear();
       // System.out.println(result_output);
        return result_output;
    }

    private static int isSubstring(int is, String s_new) {
        
        
        int M = String.valueOf(is).length();
        int N = s_new.length(); 
       // System.out.println(N);
        String s1 = String.valueOf(is);
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s_new.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return i; 
        } 
      
        return -1;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static boolean connected(int[][] adj, String start) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //int numnodes;
        //numnodes = adj.length;
        //int number_of_nodes = adj[start].length - 1;
        int[] visited = new int[hmap.size() + 1];
        int i, element;
        
        //Queue<Integer> queue = null;//new Queue<Integer>();
        Queue<Integer> queue = new LinkedList<>(); 
  //;//new AbstractQueue<Integer>();
       // System.out.println(secmp.get(i));
       int startval = secmp.get(start);
        visited[startval] = 1;
        queue.add(startval);
            
        while (!queue.isEmpty())
        {
            element = queue.remove();
            i = 1;
            System.out.println(element);
           while (i <= hmap.size())
           {
               System.out.println(adj[element][i] + " " + element + " " + i);
               if (adj[element][i] == 1 && visited[i] == 0)
               {
                   queue.add(i);
                   visited[i] = 1;
               }
               /*else if(visited[i] == 1)
               {
               checkcycle = true;
               }*/
            i++;
           }
        }
        boolean connected = false; 
 
        for (int vertex = 1; vertex <= hmap.size(); vertex++)
        {
            if (visited[vertex] == 1)
            {
                connected = true;
            } else
            { 
                connected = false;
                break;
            }
        }
 
        if (connected)
        {
           return true; //System.out.println("The graph is connected");
        } else
        {
            return false; //System.out.println("The graph is disconnected");
        }
    }
    String final_result = "";
  /*  public static void main(String[] args){
        
  /*      
        Graph graph = new Graph();
    Scanner reader = new Scanner(System.in);
        System.out.println("Enter the number of activites");
        int size = reader.nextInt();
        //int s = 0;
        
        //reader.close();
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        
        for(int i=1;i<=size;i++){
        
        //reader.nextLine();
        System.out.println("Enter activity");
        String act = reader.next();
        //reader.nextLine();
        System.out.println("Enter dependencies");
        String dep = reader.next();
        System.out.println("Enter Duration");
        int dura = reader.nextInt();
        String newvar = act + "SPLIT" + dep ;
        hmap.put(i,newvar);   
        
        durationmap.put(act, dura);
        
        }
        reader.close();
        
         Set set = hmap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         //System.out.println(mentry.getValue().toString());
         String[] getvalueofact = mentry.getValue().toString().split("SPLIT");
         
         String act_name = getvalueofact[0];
         String predes = getvalueofact[1];
         if(predes.equals("0") || predes.equals("-") || predes.equals(" ") || predes.equals(null) || predes.equals("none"))
         {
         //System.out.println("Found");
         start = act_name;
         //s = Integer.parseInt(start);
         }
         
        
        
         if(predes.contains(","))
         {
          String[] expc = predes.split(",");
          for (String a : expc) {
               graph.addEdge(a,act_name);
              
          }
            //System.out.println(a); 
         }
         else {
         graph.addEdge(predes, act_name);
         }
         
         //System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         //System.out.println(mentry.getValue());
      }
      
      for(int z = 1;z<=size;z++){
      String actname_forend = hmap.get(z).split("SPLIT")[0];
      int count = 0;
      while(iterator.hasNext()){
       Map.Entry mentry1 = (Map.Entry)iterator.next();
       //count = 0;
       if(mentry1.getValue().toString().split("SPLIT")[1].contains(actname_forend) == true){
       count++;
       }
       
      }
      
      if(count == 0){
      //END is actname_forend
      end = actname_forend;
      }
      }
      
    
      
      LinkedList<String> visited = new LinkedList();
        visited.add(start);
        new newgraph().depthFirst(graph, visited);}*/
    

    static void begin(int count_entries, String act_name, String pred, int duration){
    

        String act = act_name;//reader.next();
        String dep = pred;//reader.next();
        int dura = duration;//reader.nextInt();
        String newvar = act + "SPLIT" + dep ;
        hmap.put(count_entries,newvar);   
        
        durationmap.put(act, dura);

    
    }

    static String submitall() {
        
      Graph graph = new Graph();
      Set set = hmap.entrySet();
      Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.println(mentry.getValue().toString());
         String[] getvalueofact = mentry.getValue().toString().split("SPLIT");
         
         String act_name1 = getvalueofact[0];
         String predes = getvalueofact[1];
         if(predes.equals("0") || predes.equals("-") || predes.equals(" ") || predes.equals(null) || predes.equals("none") || predes.equals("NONE") || predes.equals("zero"))
         {
         //System.out.println("Found");
          start = act_name1;
         //s = Integer.parseInt(start);
         }
         
        
        
         if(predes.contains(","))
         {
          String[] expc = predes.split(",");
          for (String a : expc) {
               graph.addEdge(a,act_name1);
              
          }
            //System.out.println(a); 
         }
         else {
         graph.addEdge(predes, act_name1);
         }
         
         //System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         //System.out.println(mentry.getValue());
      }
       // System.out.println(hmap.isEmpty());
       // System.out.println(hmap.size());
       int adj[][] = new int[hmap.size() + 1][hmap.size() + 1];
       
       
       
       for(int m = 0; m < hmap.size() + 1; m++){
       for(int y=0; y < hmap.size() + 1; y++){
       adj[m][y] = 0;
       }
       }
       for(int v = 1;v<=hmap.size();v++)
       {
         //System.out.println(hmap.get(v).split("SPLIT")[0]);
         String actname = hmap.get(v).split("SPLIT")[0];
         //String dep = hmap.get(v).split("SPLIT")[1];
         //System.out.println(hmap.size());
         secmp.put(actname, v);
         //adj[v][]
       }
       //CHECK IF DOUBLE START
       int count_for_ds = 0;
       for(int q = 1;q<=hmap.size();q++){
       if(hmap.get(q).split("SPLIT")[1].contains("-")){
       count_for_ds++;
       }
       }
       
       System.out.println(count_for_ds);
       
       for(int v=1;v<=hmap.size();v++){
       String dep = hmap.get(v).split("SPLIT")[1];
       String actname = hmap.get(v).split("SPLIT")[0];
       System.out.println(actname + " "+ start);
       
       
       if(count_for_ds > 1){
       break;
       }
       else
       {
              if(actname.equals(start) == false)
       {
       if(dep.contains(",")){//B & A,C
           String[] dep_multiple = dep.split(",");
           for(int l = 0;l<dep_multiple.length;l++){
               int vali = secmp.get(actname);//B
               int valj = secmp.get(dep_multiple[l]);//A
               
               adj[valj][vali] = 1;
           }
       }
       else
       {
       int val_i = secmp.get(actname);//B
       int val_j = secmp.get(dep);//A
       
       adj[val_j][val_i] = 1;
       }
       }
       
       }
       

       }
       
       
 
       
       for(int m = 0; m < hmap.size() + 1; m++){
       for(int y=0; y < hmap.size() + 1; y++){
       System.out.print(adj[m][y] + "   ");
       }
       System.out.println("\n");
       }
       
       
       
       
      for(int z = 1;z<=hmap.size();z++)
      {
          
      String actname_forend = hmap.get(z).split("SPLIT")[0];
      //System.out.println("eNTER" + actname_forend);
      int count = 0;
      
      /*while(iterator.hasNext()){
       Map.Entry mentry1 = (Map.Entry)iterator.next();
       //count = 0;
          System.out.println(mentry1.getValue().toString());
       if(mentry1.getValue().toString().split("SPLIT")[1].equals(actname_forend) == true){
       count++;
       }
       
      }
      */
      
      for(int p=1;p<=hmap.size();p++)
      {
      
          String value_activity = hmap.get(p).split("SPLIT")[1];
          boolean status_comma = false;
          
          if(value_activity.contains(","))
          {
            String[] commasept = value_activity.split(",");
          
            for(String xyz: commasept)
            {
                if(actname_forend.equals(xyz))
                {
                    status_comma = true;
                    break;
                }
            }
          
          if(status_comma == true){
          count++;
          }
          
          }
          else{
          if(actname_forend.equals(value_activity))
          {
            //status_comma = true;
            //break;
              count++;
          }
          }
          
      
      }
      
      if(count == 0){
      //END is actname_forend
      end = actname_forend;
      break;
      }
      }
      
            int getstartval;
            for(int g =1;g<=hmap.size();g++)
            {
       
           if(hmap.get(g).split("SPLIT")[1].contains("-") && count_for_ds == 1)
           
           {
               
           getstartval = g;
           }
           
           
       
       }
            
            
            int g1 = 1;// = ;
            int g2 = 0;
            int endval = 0;
            HashMap<String, Integer> mapvofval = new HashMap<String, Integer>();
            System.out.print(hmap.get(1));
            System.out.print(hmap.get(0));
            for(int z=1;z<=hmap.size();z++)
            {
                
                String h = hmap.get(z).split("SPLIT")[0];
                String h1 = hmap.get(z).split("SPLIT")[1];
                if(h.equals(start)){
                g1 = z;
                }
                System.out.println(h1.contains("A"));
                mapvofval.put(h,0);
                
                if(hmap.get(z).split("SPLIT")[0].equals(end) == true){
                endval = z;
                }
                
            }
            
            int count = 0;
            while(count<=hmap.size())
           {
            System.out.println("fdfsdssf");
            String activity = hmap.get(g1).split("SPLIT")[0];
            System.out.println(activity);
           
            for(int h = 1; h<=hmap.size();h++)
            {
             if(hmap.get(h).split("SPLIT")[1].contains(activity) == true)
             {
                System.out.println("goingin");
                mapvofval.put( activity, mapvofval.get(activity) + 1 );
                g2 = h;
                break;
                }
            }
            System.out.println("fdfdf");
            g1 = g2;
            count++;
            }
            
            Set<String> s = mapvofval.keySet();
            //System.out.println(s[0]);
            Iterator<String> itr = s.iterator();
            boolean cyclic11 = false;
            while(itr.hasNext()){
            if(mapvofval.get(itr.next()) > 1){
            cyclic11= true;
            }
            }
            
            System.out.println(cyclic11);
    //  System.out.println( ":" + end);
      
      
            
      LinkedList<String> visited = new LinkedList();
        visited.add(start);
        
        //check if connected
        
       // boolean max = graph.isConnected(start,end);
       //System.out.println(end);
        
        //check if cycle
        
        
         String[] data_act_cn = new String[hmap.size()];
         int check_matrix[][] = new int[10][10];
         
          
                
        for(int z = 1;z<=hmap.size();z++)
        {
      String idk = hmap.get(z).split("SPLIT")[0];
      //System.out.println(idk);
      data_act_cn[z-1] = idk;
      
      }
        
        for (int row = 0; row < data_act_cn.length; row ++){
            for (int col = 0; col < data_act_cn.length; col++)
            {
            check_matrix[row][col] = 0;
            }}
        
        int flag = 0;
        
        for(int d = 0; d<data_act_cn.length;d++)
        {
            boolean status = false;
            for(int f=0;f<data_act_cn.length;f++)
            {
              //  System.out.println(data_act_cn[d]);
                if(d != f && data_act_cn[d] != end)
                {
                    if(check_matrix[d][f] == 0 && check_matrix[f][d] == 0){
                    status = graph.isConnected(data_act_cn[d], data_act_cn[f]);
                    if(status == false){
                    status = graph.isConnected(data_act_cn[f], data_act_cn[d]);
                    }
                   // System.out.println(status + data_act_cn[d] + data_act_cn[f]);
                    //}
                    }
                    else{
                    status = true;
                    break;
                    }
                }
                
                if(status == true)
                {
                check_matrix[d][f] = 1; 
                check_matrix[f][d] = 1;
                break; 
                }
                
            }
            if(status == false)
            {
            //send msg to gui and display it as an error
                String connectedmsg = "GRAPH IS NOT CONNECTED. RESTART THE APPLICATION AND TRY AGAIN.";
            return connectedmsg; 
            
            }
            else if(status == true)
            {
             
            flag++;
            //System.out.println("1");
            
            }
        }
      //  System.out.println(flag);
        
        if(flag == data_act_cn.length)
        {
         int flag_cyclic = 0;       
         for(int h=0;h<data_act_cn.length;h++)
         {
             boolean one = false;
             boolean two = false;
            for(int j=0;j<data_act_cn.length;j++)
            {
                if(h != j)
                {
                    one = graph.isConnected(data_act_cn[h], data_act_cn[j]);
                    two = graph.isConnected(data_act_cn[j], data_act_cn[h]);
                }
                if(one == true && two == true){
                break;
                }
            }
            if(one == true && two == true)
            {
                String cyclic = "The graph is cyclic. Please restart the program";
                return cyclic;
                
            }
            else{
            //run program
            
            flag_cyclic++;
            }
            
         }
         if(flag_cyclic == data_act_cn.length){
             
             if(count_for_ds > 1){
             return "Not connected because of double start";
             
             }
             
             else if(cyclic11 == true){
             return "Cyclic graph";
             }
             else{
              boolean result11 = connected(adj,start);
            
            if(result11 == true){
            String answer = new newgraph().depthFirst(graph, visited);
       // System.out.println(answer);
         
         String output_for_gui = parse_final_result(answer);
         return output_for_gui;
         
            }
            else{
                return "Not connected.";
            }
             
             }
           
         
         }
         else{
         
         String great1 = "ERROR: RESTART AND TRY AGAIN";
        return great1;
         }
        
        
            
            
            
            
            
            
        }
        else {
            String great = "ERROR: RESTART AND TRY AGAIN";
        return great;
        }
      
        
        
       
      
    }
    private String depthFirst(Graph graph, LinkedList<String> visited) {
     LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        // examine adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(end)) {
                visited.add(node);
                printPath(visited);
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(end)) {
                continue;
            }
            visited.addLast(node);
            depthFirst(graph, visited);
            visited.removeLast();
        }
        
        
        return final_result;
    }

    private void printPath(LinkedList<String> visited) {
        int duration_display = 0;
        String[] result = null;
        
        for (String node : visited) 
        {
            Set set = durationmap.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
            Map.Entry togetdur = (Map.Entry)iterator.next();
            if(togetdur.getKey().equals(node))
            {
                final_result = final_result + node + " - > ";
                
                
                //System.out.print(node);
                //System.out.print(" ");
                duration_display = duration_display + Integer.parseInt(togetdur.getValue().toString());
            }
            }
        }
        
        final_result = final_result + "::" + duration_display + "DURATION_SPLIT";
        //System.out.print(duration_display);
        //System.out.println();
        
        
    }
    
}
