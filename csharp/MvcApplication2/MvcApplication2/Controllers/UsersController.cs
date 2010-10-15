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
            usersDataContext db = new usersDataContext();

            // Get a typed table to run queries
            System.Data.Linq.Table<user> users = db.users;

            var yay = from u in users select u;

            List<user> enLista = yay.ToList();

            user enUser = enLista.First();

            return enUser.name;
        }

    }
}
