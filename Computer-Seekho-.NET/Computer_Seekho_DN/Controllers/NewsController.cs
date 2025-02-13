using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Service;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Controllers;

[Route("api/[controller]")]
[ApiController]
public class NewsController : ControllerBase
{
    private readonly INewsService _newsService;

    public NewsController(INewsService newsService)
    {
        _newsService = newsService;
    }

    [HttpGet]
    public async Task<ActionResult<IEnumerable<News>>> GetAllImages()
    {
        var images = await _newsService.GetAllImages();
        return Ok(images);
    }

    [HttpPost]
    public async Task<ActionResult<News>> SaveImage([FromBody] News image)
    {
        if (image == null)
            return BadRequest("Invalid image data.");

        var savedImage = await _newsService.SaveImage(image);
        return CreatedAtAction(nameof(GetImageById), new { id = savedImage.NewsId }, savedImage);
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<News>> GetImageById(int id)
    {
        var image = await _newsService.GetImageById(id);
        if (image == null)
            return NotFound();

        return Ok(image);
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteImage(int id)
    {
        await _newsService.DeleteImage(id);
        return NoContent(); // 204 No Content
    }
}