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
        jsonFile = new File("D:\\database.json");
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

    public JsonController setUniversities(List<University> universities){
        JSONArray jsonUniversities = new JSONArray();
        universities.forEach(university -> {
            JSONArray jsonFaculties = new JSONArray();
            university.getFaculties().forEach(faculty -> {
                JSONArray jsonGroups = new JSONArray();
                faculty.getGroups().forEach(group -> {
                    JSONArray jsonStudents = new JSONArray();
                    group.getStudents().forEach(student -> {
                        JSONObject jsonStudent = new JSONObject();
                        jsonStudent.put("name", student.getName());
                        jsonStudent.put("family", student.getFamily());
                        jsonStudent.put("lastName", student.getLastName());
                        jsonStudent.put("birthday", student.getBirthday());
                        jsonStudent.put("age", student.getAge());
                        jsonStudent.put("weight", student.getWeight());
                        jsonStudent.put("height", student.getHeight());
                        jsonStudent.put("scholarship", student.getScholarship());
                        jsonStudents.add(jsonStudent);
                    });

                    JSONObject jsonGroup = new JSONObject();
                    jsonGroup.put("groupName", group.getGroupName());
                    jsonGroup.put("groupRating", group.getGroupRating());
                    jsonGroup.put("students", jsonStudents);
                    jsonGroups.add(jsonGroup);
                });

                JSONObject jsonFaculty = new JSONObject();
                jsonFaculty.put("facultyName", faculty.getFacultyName());
                jsonFaculty.put("facultyRating", faculty.getFacultyRating());
                jsonFaculty.put("groups", jsonGroups);
                jsonFaculties.add(jsonFaculty);
            });

            JSONObject jsonUniversity = new JSONObject();
            jsonUniversity.put("universityName", university.getUniversityName());
            jsonUniversity.put("universityRating", university.getUniversityRating());
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

        return this;
    }

    public List<University> getUniversities(){
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
            List<Faculty> faculties = new ArrayList<>();

            ((JSONArray) jsonUniversity.get("faculties")).forEach(JSON_FACULTY -> {
                JSONObject jsonFaculty = (JSONObject) JSON_FACULTY;
                List<Group> groups = new ArrayList<>();

                ((JSONArray) jsonFaculty.get("groups")).forEach(JSON_GROUP -> {
                    JSONObject jsonGroup = (JSONObject) JSON_GROUP;
                    List<Student> students = new ArrayList<>();

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
