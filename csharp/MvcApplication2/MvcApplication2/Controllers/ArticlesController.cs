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
            var db_start = from a in db.Articles
                           where a.id == 6
                           select a;

            return View(db_start.ToList());
        }
        
        public ActionResult Articles()
        {
            var db_articles = from a in db.Articles
                              orderby a.datetime descending
                              select a;

            return View(db_articles.ToList());
        }


        public ActionResult Search()
        {
            String s = Request.Form["search_article"].ToString();
            var results = from res in db.Articles
                          where res.title.Contains(s)
                          || res.content.Contains(s)
                          orderby res.title , res.content
                          select res;

            //var search_results = db.Articles.Search("Articles, s);
                
                
                /*from tit in db.Articles
                          join cont in db.Articles on tit.id equals cont.id
                          where tit.title.Contains(s)
                          && cont.content.Contains(s)
                          orderby tit.title, cont.content
                          select new { tit.title, cont.content };*/

            return View(results.ToList());
        }

    }
}