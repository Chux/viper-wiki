<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<MvcApplication2.Models.LogOnModel>" %>

<asp:Content ID="loginTitle" ContentPlaceHolderID="TitleContent" runat="server">
    User Log In
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>UserLogIn</h2>

    <% using (Html.BeginForm()) {%>
        <%: Html.ValidationSummary(true) %>

        <fieldset>
            <legend>Fields</legend>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.UserName) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.UserName) %>
                <%: Html.ValidationMessageFor(model => model.UserName) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.Password) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.Password) %>
                <%: Html.ValidationMessageFor(model => model.Password) %>
            </div>

            
            <p>
                <input type="submit" value="Log In" />
            </p>
        </fieldset>

    <% } %>

    <div>
        <%: Html.ActionLink("Back to List", "Index") %>
    </div>

</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="SearchBarContent" runat="server">
</asp:Content>

<asp:Content ID="Content4" ContentPlaceHolderID="ArticleMenuContent" runat="server">
</asp:Content>

<asp:Content ID="Content5" ContentPlaceHolderID="MainHeaderContent" runat="server">
</asp:Content>

<asp:Content ID="Content6" ContentPlaceHolderID="FooterContent" runat="server">
</asp:Content>

