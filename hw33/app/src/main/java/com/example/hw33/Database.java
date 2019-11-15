package com.example.hw33;

import java.util.HashMap;
import java.util.List;

public class Database {

    public static HashMap<String, Search> searches = new HashMap<>();

    public static Search getSearchByID(String names) {
        return searches.get(names);

    }
        public static List<Search> getAllSearch(){
            return(List) searches.values();

        }


    public static void saveSearchToDatabase(List<Search> searchToSave){
        for (int i = 0; i<searchToSave.size(); i++){
            Search search = searchToSave.get(i);
            searches.put(search.getName(), search);
        }
    }


}


//    public static Article getArticleById(long articleID) {
//        return articles.get(articleID);
//    }
//
//    /***
//     * Return an ArrayList containing all the articles in the database.
//     */
//    public static List<Article> getAllArticles() {
//        return (List) articles.values();
//    }
//
//    // This methods simulates saving the data you get from the API to your local database.
//    // This way, we retrieve the whole object for an Article by using its ID.
//    // Keep in mind it's not a real database yet.
//    public static void saveArticlesToFakeDatabase(List<Article> articlesToSave) {
//        for(int i = 0; i < articlesToSave.size(); i++) {
//            Article article = articlesToSave.get(i);
//            articles.put(article.getId(), article);
//        }
//    }
