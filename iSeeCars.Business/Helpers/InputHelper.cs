using System.Globalization;
namespace iSeeCars.Business.Helpers
{
    public static class InputHelper
    {
        public static int ReadInt(string message, Func<int, bool> validate, string errorMessage)
        {
            while (true)
            {
                Console.WriteLine(message);
                string input = Console.ReadLine();

                if (int.TryParse(input, out int value) && validate(value))
                    return value;

                ConsoleHelper.PrintErrorMessage(errorMessage);
            }

        }
        public static double ReadDouble(string message, Func<double, bool> validate, string errorMessage)
        {
            while (true)
            {
                Console.WriteLine(message);
                string input = Console.ReadLine();

                input = input.Replace(",", ".");


                if (double.TryParse(input, NumberStyles.Any, CultureInfo.InvariantCulture, out double value))
                    if (validate == null || validate(value))
                        return value;

                ConsoleHelper.PrintErrorMessage(errorMessage);
            }
        }

        public static string ReadString(string message, Func<string, bool> validate, string errorMessage)
        {

            while (true)
            {
                Console.WriteLine(message);
                string input = Console.ReadLine();

                if (validate(input))
                    return input;


                ConsoleHelper.PrintErrorMessage(errorMessage);
            }

        }

        public static void ShowEnum<T>()
        {
            foreach (var item in Enum.GetValues(typeof(T)))
            {
                Console.WriteLine($"{(int)item}.{item}");
            }
        }
    }
}
