package com.company;

import static com.company.InputClass.input;

class Commands<T> {

    void commandLine(T value, int position){
        if (value instanceof Student) return;
        Shower shower = (Shower) value;
        Action action = (Action) value;
        boolean exit = true;

        do {
            String textCmd =
                    "Insert command id: " + "\n" +
                    "                   1) Add new " + shower.getChildrenTypeName() + "\n" +
                    "                   2) Delete " + shower.getChildrenTypeName() + "\n" +
                    "                   3) Update " + shower.getChildrenTypeName() + "\n" +
                    "                   4) Search " + shower.getChildrenTypeName() + "\n" +
                    "                   5) Show " + shower.getChildrenTypeName() + " Data List\n" +
                    "                   6) Exit the "+ shower.getChildrenTypeName() +" Data List ";
            System.out.println(textCmd);
            System.out.print("Enter Id: ");

            int command = input(Integer.class);

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
