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
                if (articletitle == "All")
                {
                    return Redirect( "All" );
                }
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
        
        public ActionResult All()
        {
            var db_articles = from a in db.Articles
                              orderby a.datetime descending
                              select a;
            return View(db_articles.ToList());
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

        public ActionResult Search()
        {
            String s = Request.Form["search_text"].ToString();
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
