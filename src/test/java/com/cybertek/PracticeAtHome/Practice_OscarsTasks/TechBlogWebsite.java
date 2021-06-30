package com.cybertek.PracticeAtHome.Practice_OscarsTasks;

/*
1- Go to https://techcrunch.com/
2- For “The Latest News” list, verify followings;
	a. each news has an author
	b. each news has an image
3- Click one of news from “The Latest News” list to reach the full content and verify followings;
	a. the browser title is the same with the news title
	b. the links within the news content
 */

import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TechBlogWebsite {

    @Test
    public void verifyAuthorAndImage() {
        Driver.getDriver().get("https://techcrunch.com/");
        Assert.assertEquals(TechBlogUtils.getAllNews().size(),TechBlogUtils.getAllAuthors().size());
        Assert.assertEquals(TechBlogUtils.getAllNews().size(), TechBlogUtils.getAllImages().size());

    }

    @Test
    public void verifyTitle() {

        Driver.getDriver().getTitle();
        Assert.assertTrue(TechBlogUtils.getPageTitle(1).contains(TechBlogUtils.getArticleTitle(1)));

    }




}
