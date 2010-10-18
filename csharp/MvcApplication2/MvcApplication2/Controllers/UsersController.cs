using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcApplication2.Models;
using System.Linq;
using System.Data;

namespace MvcApplication2.Controllers
{
    public class UsersController : Controller
    {

        //
        // GET: /Users/

        public ActionResult Index()
        {
            ViewData["title"] = "Users index";
            ViewData["content"] = getAllUsers();
            return View();
        }

        private String getAllUsers()
        {

            // Use a standard connection string
            UsersDataContext db = new UsersDataContext();

            // Get a typed table to run queries
            System.Data.Linq.Table<User> users = db.Users;

            var yay = from u in users select u;

            List<User> enLista = yay.ToList(); 
        

            User enUser = enLista.First();

            return enUser.username;
        }

    }
}
