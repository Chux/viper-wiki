<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<MvcApplication2.Models.User>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	Create
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>Create</h2>

    <% using (Html.BeginForm()) {%>
        <%: Html.ValidationSummary(true) %>

        <fieldset>
            <legend>Fields</legend>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.username) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.username) %>
                <%: Html.ValidationMessageFor(model => model.username) %>
            </div>
            
            <div class="editor-label">
                <%: Html.LabelFor(model => model.password) %>
            </div>
            <div class="editor-field">
                <%: Html.TextBoxFor(model => model.password) %>
                <%: Html.ValidationMessageFor(model => model.password) %>
            </div>

            
            <p>
                <input type="submit" value="Create" />
            </p>
        </fieldset>

    <% } %>

    <div>
        <%: Html.ActionLink("Back to List", "Index") %>
    </div>

</asp:Content>