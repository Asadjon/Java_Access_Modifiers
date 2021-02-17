package com.company;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class JsonController {

    private static JsonController jsonController;
    private File jsonFile;

    static JsonController initJsonController(){ return jsonController != null ? jsonController : (jsonController = new JsonController()); }

    private JsonController() {
        jsonFile = new File("database.json");
        try {
            if (jsonFile.createNewFile()){
                System.out.println("Json file created");
            } else {
                System.out.println("Json file not created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setUniversities(List<Object> universities){
        JSONArray jsonUniversities = new JSONArray();
        universities.forEach(university -> {
            JSONArray jsonFaculties = new JSONArray();
            ((University)university).getObjects().forEach(faculty -> {
                JSONArray jsonGroups = new JSONArray();
                ((Faculty)faculty).getObjects().forEach(group -> {
                    JSONArray jsonStudents = new JSONArray();
                    ((Group)group).getObjects().forEach(student -> {
                        JSONObject jsonStudent = new JSONObject();
                        jsonStudent.put("name", ((Student)student).getName());
                        jsonStudent.put("family", ((Student)student).getFamily());
                        jsonStudent.put("lastName", ((Student)student).getLastName());
                        jsonStudent.put("birthday", ((Student)student).getBirthday());
                        jsonStudent.put("age", ((Student)student).getAge());
                        jsonStudent.put("weight", ((Student)student).getWeight());
                        jsonStudent.put("height", ((Student)student).getHeight());
                        jsonStudent.put("scholarship", ((Student)student).getScholarship());
                        jsonStudents.add(jsonStudent);
                    });

                    JSONObject jsonGroup = new JSONObject();
                    jsonGroup.put("groupName", ((Group)group).getName());
                    jsonGroup.put("groupRating", ((Group)group).getRating());
                    jsonGroup.put("students", jsonStudents);
                    jsonGroups.add(jsonGroup);
                });

                JSONObject jsonFaculty = new JSONObject();
                jsonFaculty.put("facultyName", ((Faculty)faculty).getName());
                jsonFaculty.put("facultyRating", ((Faculty)faculty).getRating());
                jsonFaculty.put("groups", jsonGroups);
                jsonFaculties.add(jsonFaculty);
            });

            JSONObject jsonUniversity = new JSONObject();
            jsonUniversity.put("universityName", ((University)university).getName());
            jsonUniversity.put("universityRating", ((University)university).getRating());
            jsonUniversity.put("faculties", jsonFaculties);
            jsonUniversities.add(jsonUniversity);
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Universities", jsonUniversities);

        try {
            String s = jsonObject.toString();
            FileWriter fileWriter = new FileWriter(jsonFile.getPath());
            fileWriter.write(s);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    List<University> getUniversities(){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader(jsonFile.getPath()));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        JSONArray jsonUniversities = (JSONArray) jsonObject.get("Universities");
        List<University> universities = new ArrayList<>();

        jsonUniversities.forEach(JSON_UNIVERSITY -> {
            JSONObject jsonUniversity = (JSONObject) JSON_UNIVERSITY;
            List<Object> faculties = new ArrayList<>();

            ((JSONArray) jsonUniversity.get("faculties")).forEach(JSON_FACULTY -> {
                JSONObject jsonFaculty = (JSONObject) JSON_FACULTY;
                List<Object> groups = new ArrayList<>();

                ((JSONArray) jsonFaculty.get("groups")).forEach(JSON_GROUP -> {
                    JSONObject jsonGroup = (JSONObject) JSON_GROUP;
                    List<Object> students = new ArrayList<>();

                    ((JSONArray) jsonGroup.get("students")).forEach(JSON_STUDENT -> {
                        JSONObject jsonStudent = (JSONObject) JSON_STUDENT;
                        students.add(new Student(
                                jsonStudent.get("name").toString(),
                                jsonStudent.get("family").toString(),
                                jsonStudent.get("lastName").toString(),
                                jsonStudent.get("birthday").toString(),
                                Integer.parseInt(jsonStudent.get("age").toString()),
                                Double.parseDouble(jsonStudent.get("weight").toString()),
                                Double.parseDouble(jsonStudent.get("height").toString()),
                                Double.parseDouble(jsonStudent.get("scholarship").toString())
                        ));
                    });

                    groups.add(new Group(
                            jsonGroup.get("groupName").toString(),
                            Integer.parseInt(jsonGroup.get("groupRating").toString()),
                            students
                    ));
                });

                faculties.add(new Faculty(
                        jsonFaculty.get("facultyName").toString(),
                        Integer.parseInt(jsonFaculty.get("facultyRating").toString()),
                        groups
                ));
            });

            universities.add(new University(
                    jsonUniversity.get("universityName").toString(),
                    Integer.parseInt(jsonUniversity.get("universityRating").toString()),
                    faculties
            ));
        });

        return universities;
    }


}
