using iSeeCars.Core.Entities;

namespace iSeeCars.Business.Managers
{
    public class ModelManager
    {
        List<Model> models = new List<Model>();
        private int nextId = 1;

        // Console üçün
        public Model AddModel()
        {
        mdlName:
            Console.WriteLine("Enter a model name:");
            string mdlName = Console.ReadLine();
            if (string.IsNullOrWhiteSpace(mdlName))
            {
                Console.WriteLine("Model name can not be empty");
                goto mdlName;
            }

            Model newModel = new Model
            {
                ModelId = nextId++,
                ModelName = mdlName
            };
            models.Add(newModel);
            return newModel;
        }

        // API üçün
        public Model AddModel(Model model)
        {
            if (model == null || string.IsNullOrWhiteSpace(model.ModelName))
                throw new ArgumentException("Model is null or name is empty");

            model.ModelId = nextId++;
            models.Add(model);
            return model;
        }
        public Model GetModelById(int id)
        {
            var model = models.FirstOrDefault(m => m.ModelId == id);
            if (model == null)
            {
                Console.WriteLine("Model not found");
            }


            return model;

        }
        public List<Model> GetAllModels()
        {
            return models;
        }
        public void ShowAllModels()
        {
            if (models.Count == 0)
            {
                Console.WriteLine("Model not found");
            }
            else
            {
                foreach (var mdl in models)
                {
                    Console.WriteLine($"{mdl.ModelId}.{mdl.ModelName}");
                }

            }
        }
      
        public void RemoveModel(Model model)
        {
            models.Remove(model);
        }
    }
}
