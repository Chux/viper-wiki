using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcApplication2.Models;

namespace MvcApplication2.Controllers
{
    public class ArticlesController : Controller
    {
        //
        // GET: /Articles/

        ArticleEntities db = new ArticleEntities();

        public ActionResult Index()
        {
            var db_articles = from a in db.Articles
                              select a;

            return View(db_articles.ToList());
        }

    }
}
