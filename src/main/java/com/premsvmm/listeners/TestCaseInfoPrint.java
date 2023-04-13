package com.premsvmm.listeners;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCaseInfoPrint {

    public static void main(String[] args) throws Exception {
        String packageName = "com.premsvmm.tests"; // Replace with your package name
        List<Class<?>> classes = getClasses(packageName);
        generateReport(classes);
        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(TestCaseInfo.class) && method.isAnnotationPresent(Test.class)) {
                    TestCaseInfo testCaseInfo = method.getAnnotation(TestCaseInfo.class);
                    Test test = method.getAnnotation(Test.class);
                    System.out.println("Class: " + clazz.getName() + ", Method: " + method.getName() + ", Test Case Info: " + testCaseInfo.service() + ", " + testCaseInfo.feature() + ", " + testCaseInfo.usecase() + ", " + testCaseInfo.testDescription() + ", " + testCaseInfo.author() + ",Test Name: " + test.testName() + " ,Test Group: " + Arrays.asList(test.groups()));
                }
            }
        }
    }

    private static List<Class<?>> getClasses(String packageName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new IllegalArgumentException("Package " + packageName + " not found");
        }
        File directory = new File(resource.getFile());
        List<String> classNames = new ArrayList<>();
        if (directory.exists()) {
            findClasses(classNames, directory, packageName);
        } else {
            throw new IllegalArgumentException("Package " + packageName + " not found");
        }
        return classNames.stream().map(name -> {
            try {
                return Class.forName(name);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Failed to load class " + name, e);
            }
        }).collect(Collectors.toList());
    }

    private static void findClasses(List<String> classNames, File directory, String packageName) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    String subdir = packageName + "." + file.getName();
                    findClasses(classNames, file, subdir);
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                    classNames.add(className);
                }
            }
        }
    }

    public static void generateReport(List<Class<?>> classes) throws IOException, IOException {
        String html = "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<title>Test Results</title>\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "<style>\n" +
                "table {\n" +
                "  margin-bottom: 0;\n" +
                "}\n" +
                "thead {\n" +
                "  background-color: #007bff;\n" +
                "  color: #fff;\n" +
                "}\n" +
                "th {\n" +
                "  text-align: left;\n" +
                "  padding: 12px;\n" +
                "  font-weight: 500;\n" +
                "  vertical-align: middle;\n" +
                "}\n" +
                "td {\n" +
                "  vertical-align: middle;\n" +
                "}\n" +
                "#resultsTable tr:nth-child(even) {\n" +
                "  background-color: #f2f2f2;\n" +
                "}\n" +
                ".form-control {\n" +
                "  margin-bottom: 10px;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<header class=\"container my-4\">\n" +
                "<h1 class=\"display-4\">Test Results</h1>\n" +
                "<p class=\"lead\">Filter the results by entering a search term in the input field below:</p>\n" +
                "<div class=\"form-group\">\n" +
                "<input type=\"search\" id=\"filterInput\" class=\"form-control\" placeholder=\"Search\">\n" +
                "</div>\n" +
                "</header>\n" +
                "<main class=\"container\">\n" +
                "<div class=\"table-responsive\">\n" +
                "<table id=\"resultsTable\" class=\"table table-bordered\">\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th>Class</th>\n" +
                "<th>Method</th>\n" +
                "<th>Service</th>\n" +
                "<th>Feature</th>\n" +
                "<th>Use Case</th>\n" +
                "<th>Description</th>\n" +
                "<th>Test Group</th>\n" +
                "<th>Author</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n";

        for (Class<?> clazz : classes) {
            for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
                Annotation annotation = method.getAnnotation(TestCaseInfo.class);
                Annotation test = method.getAnnotation(Test.class);
                if (annotation != null && test != null) {
                    TestCaseInfo testCaseInfo = (TestCaseInfo) annotation;
                    Test testDetail = (Test) test;
                    html += "<tr><td>" + clazz.getName() + "</td><td>" + method.getName() + "</td><td>" +
                            testCaseInfo.service() + "</td><td>" + testCaseInfo.feature() + "</td><td>" +
                            testCaseInfo.usecase() + "</td><td>" + testCaseInfo.testDescription() +
                            "</td><td>" + Arrays.asList(testDetail.groups()) + "</td></td>" +
                            "</td><td>" + testCaseInfo.author() + "</td></tr>\n";
                }
            }
        }

        html += "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</main>\n" +
                "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n" +
                "<script>\n" +
                "$(document).ready(function(){\n" +
                "  $('#filterInput').on('keyup', function() {\n" +
                "    var value = $(this).val().toLowerCase();\n" +
                "    $('#resultsTable tbody tr').filter(function() {\n" +
                "      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)\n" +
                "    });\n" +
                "  });\n" +
                "});\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>\n";

        FileWriter writer = new FileWriter("report.html");
        writer.write(html);
        writer.close();
    }
}
