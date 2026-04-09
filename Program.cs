using iSeeCars.Managers;
using iSeeCars.Services;
using Microsoft.Extensions.DependencyInjection;

namespace iSeeCars
{
    internal class Program
    {

        static void Main(string[] args)
        {
            var serviceProvider = new ServiceCollection()
                .AddSingleton<CarManager>()
                .AddSingleton<ModelManager>()
                .AddSingleton<InputService>()
                .AddSingleton<MenuService>()
                .BuildServiceProvider();
           
            var menuService = serviceProvider.GetRequiredService<MenuService>();
            menuService.ReadMenu();
        }

    }
}
