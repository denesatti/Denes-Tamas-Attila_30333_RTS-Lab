package Ex1;


import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataREL;
import DataObjects.DataRELQueue;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import PetriDataPackage.Guard;

import java.util.ArrayList;

public class SupervisorTamas {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();

        pn.PetriNetName = "Supervisor Petri";
        pn.NetworkPort  = 1082;

        DataREL ps_i1 = new DataREL();
        ps_i1.SetName("ps_i1");
        pn.PlaceList.add(ps_i1);

        DataRELQueue ps_1 = new DataRELQueue();
        //ps_1.SetName("c");
        ps_1.SetName("ps_1");
        ps_1.Value.Size = 10;
        pn.PlaceList.add(ps_1);

        DataTransfer ps_o1 = new DataTransfer();
        ps_o1.SetName("ps_o1");
        ps_o1.Value = new TransferOperation("localhost","1080","p_i1");
        pn.PlaceList.add(ps_o1);

        DataInteger ps_2 = new DataInteger();
        ps_2.SetName("ps_2");
        ps_2.SetValue(0);
        pn.PlaceList.add(ps_2);

        DataInteger ps_3 = new DataInteger();
        ps_3.SetName("ps_3");
        ps_3.SetValue(0);
        pn.PlaceList.add(ps_3);

        DataInteger ps_o2 = new DataInteger();
        ps_o2.SetName("ps_o2");
        pn.PlaceList.add(ps_o2);

        DataInteger ps_i2 = new DataInteger();
        ps_i2.SetName("ps_i2");
        pn.PlaceList.add(ps_i2);

    //-----------------------------------Ts_1----------------------------------//
        PetriTransition ts_1 = new PetriTransition(pn);
        ts_1.TransitionName = "ts_1";
        ts_1.InputPlaceName.add("ps_i1");
        ts_1.InputPlaceName.add("ps_1");

    //---------------grd1---------------//
        Condition T1Ct1 = new Condition(ts_1,"ps_i1", TransitionCondition.NotNull);

        GuardMapping grd1T11 = new GuardMapping();

        grd1T11.condition = T1Ct1;

        grd1T11.Activations.add(new Activation(ts_1,"ps_i1", TransitionOperation.AddElement,"ps_1"));
        ts_1.GuardMappingList.add(grd1T11);

        ts_1.Delay = 0;
        pn.Transitions.add(ts_1);

    //-----------------------------------Ts_2----------------------------------//

        PetriTransition ts_2 = new PetriTransition(pn);
        ts_2.TransitionName = "ts_2";

        ts_2.InputPlaceName.add("ps_1");
        ts_2.InputPlaceName.add("ps_2");
        ts_2.InputPlaceName.add("ps_3");

        ArrayList<String> OutputPlaces =  new ArrayList<String>() ;
        OutputPlaces.add("ps_o1");
        OutputPlaces.add("ps_3");

        //---------------grd1---------------//
        Condition T2Ct1 = new Condition(ts_2, "ps_1",TransitionCondition.HaveREL);
        Condition T2Ct2 = new Condition(ts_2, "ps_2",TransitionCondition.NotNull);
        Condition T2Ct3 = new Condition(ts_2, "ps_3",TransitionCondition.NotNull);

        T2Ct2.SetNextCondition(LogicConnector.AND,T2Ct3);
        T2Ct1.SetNextCondition(LogicConnector.AND,T2Ct2);

        GuardMapping grd1T21 = new GuardMapping();
        grd1T21.condition = T2Ct1;
        grd1T21.Activations.add(new Activation(ts_2,"ps_1",TransitionOperation.SendROverNetwork,"ps_o1"));
        //grd1T21.Activations.add(new Activation(ts_2,"ps_3",TransitionOperation.PopElement_R_E,OutputPlaces));
        grd1T21.Activations.add(new Activation(ts_2,"ps_1",TransitionOperation.PopElement_R_E,OutputPlaces));


        ts_2.GuardMappingList.add(grd1T21);

        ts_2.Delay = 0;
        pn.Transitions.add(ts_2);
    //-----------------------------------Ts_3----------------------------------//
        PetriTransition ts_3 = new PetriTransition(pn);
        ts_3.TransitionName = "ts_3";
        ts_3.InputPlaceName.add("ps_i2");

    //---------------grd2---------------//
        Condition T3Ct1 = new Condition(ts_3, "ps_i2", TransitionCondition.NotNull);

        GuardMapping grd1T31 = new GuardMapping();
        grd1T31.condition = T3Ct1;

        grd1T31.Activations.add(new Activation(ts_3,"ps_i2", TransitionOperation.Move,"ps_2"));
        grd1T31.Activations.add(new Activation(ts_3,"ps_i2", TransitionOperation.Move,"ps_o2"));

        ts_3.GuardMappingList.add(grd1T31);

        ts_3.Delay = 0;
        pn.Transitions.add(ts_3);

    //---------------------------------------System---------------------------------------//S
    System.out.println("Supervisor started \n ------------------------------");
    pn.Delay = 3000;
    // pn.Start();

    PetriNetWindow frame = new PetriNetWindow(false);
    frame.petriNet = pn;
    frame.setVisible(true);


    }
}
