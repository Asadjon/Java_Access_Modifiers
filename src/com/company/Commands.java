package com.company;

import com.company.InputClass.TypeVariable;

class Commands<T> {

    void commandLine(T value, int position){
        if (value instanceof Student) return;
        Shower shower = (Shower) value;
        Action action = (Action) value;
        boolean exit = true;

        do {
            String textCmd =
                    "Insert command id: " + "\n" +
                    "                   1) Add new " + shower.getChildrenClassName() + "\n" +
                    "                   2) Delete " + shower.getChildrenClassName() + "\n" +
                    "                   3) Update " + shower.getChildrenClassName() + "\n" +
                    "                   4) Search " + shower.getChildrenClassName() + "\n" +
                    "                   5) Show " + shower.getChildrenClassName() + " Data List\n" +
                    "                   6) Exit the "+ shower.getChildrenClassName() +" Data List ";
            System.out.println(textCmd);
            System.out.print("Enter Id: ");

            int command = (int) InputClass.input(TypeVariable.Int);

            switch (command){
                case 1:
                    action.Add();
                    JsonController.initJsonController().setUniversities(Database.initDatabase().getObjects());
                    shower.show(position);
                break;

                case 2:
                    action.Delete();
                    JsonController.initJsonController().setUniversities(Database.initDatabase().getObjects());
                    shower.show(position);
                    break;

                case 3:
                    action.Update();
                    JsonController.initJsonController().setUniversities(Database.initDatabase().getObjects());
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
