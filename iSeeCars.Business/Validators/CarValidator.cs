using FluentValidation;
using iSeeCars.Core.Entities;

namespace iSeeCars.Business.Validators
{
    public class CarValidator : AbstractValidator<Car>
    {
        public CarValidator()
        {
            RuleFor(x => x.ModelId)
                .GreaterThan(0)
                .WithMessage("Model must be selected");

            RuleFor(x => x.Price)
                .GreaterThan(0)
                .WithMessage("Price must be greater than 0");

            RuleFor(x => x.Color)
                .NotEmpty()
                .WithMessage("Color cannot be empty")
                .MaximumLength(30);

            RuleFor(x => x.Engine)
                .GreaterThan(0)
                .WithMessage("Engine must be greater than 0");

            RuleFor(x => x.Year)
                   .InclusiveBetween(1900, DateTime.Now.Year)
                   .WithMessage("Invalid year");


            RuleFor(x => x.FuelType)
                .IsInEnum()
                .WithMessage("Invalid fuel type");
        }
    }
}