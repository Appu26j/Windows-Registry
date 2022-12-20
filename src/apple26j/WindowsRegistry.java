package apple26j;

import java.util.Scanner;

public class WindowsRegistry
{
    public static boolean addSubKey(String subKey)
    {
        try
        {
            Process process = Runtime.getRuntime().exec("reg add \"" + subKey + "\"");
            Scanner scanner = new Scanner(process.getInputStream());
            return scanner.nextLine().equalsIgnoreCase("The operation completed successfully.");
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean deleteSubKey(String subKey)
    {
        try
        {
            Process process = Runtime.getRuntime().exec("reg delete \"" + subKey + "\" /f");
            Scanner scanner = new Scanner(process.getInputStream());
            return scanner.nextLine().equalsIgnoreCase("The operation completed successfully.");
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean addDWORDEntry(String entry, String value)
    {
        try
        {
            StringBuilder parentPath = new StringBuilder();
            String [] array = entry.split("\\\\");

            for (int i = 0; i < array.length - 1; i++)
            {
                parentPath.append(array[i]).append("\\");
            }

            parentPath = new StringBuilder(parentPath.substring(0, parentPath.length() - 1));
            Process process = Runtime.getRuntime().exec("reg add \"" + parentPath + "\" /v " + entry.split("\\\\")[entry.split("\\\\").length - 1] + " /t REG_DWORD /d " + value);
            Scanner scanner = new Scanner(process.getInputStream());
            return scanner.nextLine().equalsIgnoreCase("The operation completed successfully.");
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean addQWORDEntry(String entry, String value)
    {
        try
        {
            StringBuilder parentPath = new StringBuilder();
            String [] array = entry.split("\\\\");

            for (int i = 0; i < array.length - 1; i++)
            {
                parentPath.append(array[i]).append("\\");
            }

            parentPath = new StringBuilder(parentPath.substring(0, parentPath.length() - 1));
            Process process = Runtime.getRuntime().exec("reg add \"" + parentPath + "\" /v " + entry.split("\\\\")[entry.split("\\\\").length - 1] + " /t REG_QWORD /d " + value);
            Scanner scanner = new Scanner(process.getInputStream());
            return scanner.nextLine().equalsIgnoreCase("The operation completed successfully.");
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean addBinaryValueEntry(String entry, String value)
    {
        try
        {
            StringBuilder parentPath = new StringBuilder();
            String [] array = entry.split("\\\\");

            for (int i = 0; i < array.length - 1; i++)
            {
                parentPath.append(array[i]).append("\\");
            }

            parentPath = new StringBuilder(parentPath.substring(0, parentPath.length() - 1));
            Process process = Runtime.getRuntime().exec("reg add \"" + parentPath + "\" /v " + entry.split("\\\\")[entry.split("\\\\").length - 1] + " /t REG_BINARY /d " + value);
            Scanner scanner = new Scanner(process.getInputStream());
            return scanner.nextLine().equalsIgnoreCase("The operation completed successfully.");
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean deleteEntry(String entry)
    {
        try
        {
            StringBuilder parentPath = new StringBuilder();
            String [] array = entry.split("\\\\");

            for (int i = 0; i < array.length - 1; i++)
            {
                parentPath.append(array[i]).append("\\");
            }

            parentPath = new StringBuilder(parentPath.substring(0, parentPath.length() - 1));
            Process process = Runtime.getRuntime().exec("reg delete \"" + parentPath + "\" /v " + entry.split("\\\\")[entry.split("\\\\").length - 1] + " /f");
            Scanner scanner = new Scanner(process.getInputStream());
            return scanner.nextLine().equalsIgnoreCase("The operation completed successfully.");
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean deleteAllValuesFromSubKey(String subKey)
    {
        try
        {
            Process process = Runtime.getRuntime().exec("reg delete \"" + subKey + "\" /f /va");
            Scanner scanner = new Scanner(process.getInputStream());
            return scanner.nextLine().equalsIgnoreCase("The operation completed successfully.");
        }

        catch (Exception e)
        {
            return false;
        }
    }
}
