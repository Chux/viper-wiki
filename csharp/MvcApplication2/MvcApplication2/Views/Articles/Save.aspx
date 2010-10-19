<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<dynamic>" %>

<asp:Content ID="Content5" ContentPlaceHolderID="MainHeaderContent" runat="server">
    Article saved
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	Article saved
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
<h2><%: ViewData["ArticleTitle"] %></h2>
<p><%: ViewData["Result"] %></p>
</asp:Content>

