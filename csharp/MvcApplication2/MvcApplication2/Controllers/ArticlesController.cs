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

        public ActionResult Index( string articletitle )
        {
            string tArticleContent;

            if (String.IsNullOrEmpty(articletitle))
            {
                articletitle = "Start";
                tArticleContent = GetArticleContent("start");
            }
            else
            {
                tArticleContent = GetArticleContent(articletitle);
                if (String.IsNullOrEmpty(GetArticleContent(articletitle)))
                {
                    // Give the option to write new article!
                    articletitle = "Article does not exist";
                }
            }
            ViewData["ArticleTitle"] = articletitle;
            ViewData["ArticleContent"] = tArticleContent;            
            return View();
        }

        public ActionResult Edit()
        {

            return View();
        }

        public ActionResult HandleSaveArticleForm(string article_title, string article_content)
        {

            return View();
        }

        public String GetArticleContent(String pArticleTitle)
        {
            var result = from a in db.Articles
                         where a.title == pArticleTitle
                         select a;
            try
            {
                Article article = result.Single();
                return article.content;
            }
            catch
            {
                return "";
            }
        }

    }
}
