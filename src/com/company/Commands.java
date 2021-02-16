package com.company;

import com.company.InputClass.TypeVariable;

class Commands<T> {

    void commandLine(T value, int position){
        Shower shower = (Shower) value;
        Action action = (Action) value;
        boolean exit = true;

        do {
            String textCmd =
                    "Insert command id: " + "\n" +
                    "                   1) Add new " + shower.getClassName() + "\n" +
                    "                   2) Delete " + shower.getClassName() + "\n" +
                    "                   3) Update " + shower.getClassName() + "\n" +
                    "                   4) Search " + shower.getClassName() + "\n" +
                    "                   5) Show " + shower.getClassName() + " Data List\n" +
                    "                   6) Exit the "+ shower.getClassName() +" Data List ";
            System.out.println(textCmd);
            System.out.print("Enter Id: ");

            int command = (int) InputClass.input(TypeVariable.Int);

            switch (command){
                case 1:
                    action.Add();
                    JsonController.initJsonController().setUniversities(Database.initDatabase().getUniversities());
                    shower.show(position);
                break;

                case 2:
                    action.Delete();
                    JsonController.initJsonController().setUniversities(Database.initDatabase().getUniversities());
                    shower.show(position);
                    break;

                case 3:
                    action.Update();
                    JsonController.initJsonController().setUniversities(Database.initDatabase().getUniversities());
                    shower.show(position);
                    break;

                case 4:
                    action.Search();
                    break;

                case 5:
                    shower.show(position);
                    break;

                case 6:
                    exit = false;
                    break;

                default: System.out.println("Not found command!");
            }


        } while (exit);
    }
}
