using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcApplication2.Models;

namespace MvcApplication2.Controllers
{
    public class UsersController : Controller
    {
        //
        // GET: /Users/

        UserEntities db = new UserEntities();
 
        public ActionResult Index()
        {
            var db_users = from u in db.Users select u;

            return View(db_users.ToList());
 
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(User newUser)
        {

            if (ModelState.IsValid)
            {
                db.AddToUsers(newUser);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            else
            {
                return View(newUser);
            }
        }

    }
}
