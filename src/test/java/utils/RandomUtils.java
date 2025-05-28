package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getRandomDateOfBirth() {
        return String.valueOf(getRandomInt(1, 28));
    }

    public static String getRandomMonthOfBirth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        return getRandomItemFromArray(months);
    }

    public static String getRandomYearOfBirth() {
        return String.valueOf(getRandomInt(1955, 2023));
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies", "Biology", "Physics", "Computer Science", "Chemistry", "Commerce", "Arts", "Economics", "Social Studies", "Civics", "Hindi", "English", "History"};
        return getRandomItemFromArray(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Reading", "Sports", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"img1.png", "img2.png"};
        return getRandomItemFromArray(pictures);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(states);
    }

    public static String getRandomCityByState(String state) {
        String[] cities;

        switch (state) {
            case "NCR":
                cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                break;
            case "Uttar Pradesh":
                cities = new String[]{"Agra", "Lucknow", "Merrut"};
                break;
            case "Haryana":
                cities = new String[]{"Karnal", "Panipat"};
                break;
            case "Rajasthan":
                cities = new String[]{"Jaipur", "Jaiselmer"};
                break;
            default:
                cities = new String[]{"Unknown"};
        }

        return getRandomItemFromArray(cities);
    }

}