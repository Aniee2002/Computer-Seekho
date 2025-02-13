
using Microsoft.AspNetCore.Mvc;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Services;

namespace Computer_Seekho_DN.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ImageController : ControllerBase
    {
        private readonly IImageService _imageService;

        public ImageController(IImageService imageService)
        {
            _imageService = imageService;
        }

        // GET: api/image
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Image>>> GetAllImages()
        {
            var images = await _imageService.GetAllImagesAsync();
            return Ok(images);
        }

        // POST: api/image
        [HttpPost]
        public async Task<ActionResult<Image>> AddImage([FromBody] Image image)
        {
            if (image == null)
            {
                return BadRequest("Invalid image data.");
            }

            var addedImage = await _imageService.AddImageAsync(image);
            return CreatedAtAction(nameof(GetAllImages), new { id = addedImage.ImageId }, addedImage);
        }

        // DELETE: api/image/{id}
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteImage(int id)
        {
            var result = await _imageService.DeleteImageAsync(id);
            if (!result)
            {
                return NotFound("Image not found.");
            }

            return NoContent();
        }
    }
}
