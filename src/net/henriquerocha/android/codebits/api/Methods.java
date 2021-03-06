/*  
 *  Codebits
 *  Copyright (C) 2012 Henrique Rocha <hmrocha@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.henriquerocha.android.codebits.api;

import java.io.IOException;

import net.henriquerocha.android.codebits.NetworkUtils;

public class Methods {
    @SuppressWarnings("unused")
    private static final String TAG = Methods.class.getSimpleName();

    public static final String SERVICES_URL = "https://services.sapo.pt/Codebits";
    public static final String CALL_FOR_TALKS = SERVICES_URL + "/calltalks";
    public static final String GET_TOKEN = SERVICES_URL + "/gettoken";
    public static final String CALL_UP_TALK = SERVICES_URL + "/calluptalk";
    public static final String CALL_DOWN_TALK = SERVICES_URL + "/calldowntalk";
    public static final String USER = SERVICES_URL + "/user";
    public static final String NICK = SERVICES_URL + "/nick";

    /**
     * Auth token
     * 
     * Get the auth token. Will be used as a &token= argument with all the
     * authenticated methods. Please be aware that tokens may expire (due to
     * timeout, IP change or others). The correct procedure for an app is to ask
     * for a new token if the one it has fails in any of the methods that
     * require authentication.
     * 
     * @param user
     *            the user's e-mail
     * @param password
     *            the user's password
     * @return the auth token
     * @throws IOException
     */
    public static String getToken(String user, String password) throws IOException {
        String url = GET_TOKEN + "?user=" + user + "&password=" + password;
        return NetworkUtils.downloadUrl(url);
    }

    /**
     * Vote up a proposed talk.
     * 
     * @param id
     *            the talk ID
     * @param token
     *            auth token
     * @throws IOException
     */
    public static void callUpTalk(int id, String token) throws IOException {
        String url = CALL_UP_TALK + "/" + id + "?token=" + token;
        NetworkUtils.downloadUrl(url);
    }

    /**
     * Vote down a proposed talk.
     * 
     * @param id
     *            the talk ID
     * @param token
     *            auth token
     * @throws IOException
     */
    public static void callDownTalk(int id, String token) throws IOException {
        String url = CALL_DOWN_TALK + "/" + id + "?token=" + token;
        NetworkUtils.downloadUrl(url);
    }

    /**
     * User's info
     * 
     * @param id
     *            the talk ID
     * @param token
     *            auth token
     */
    public static String user(int id, String token) throws IOException {
        String url = USER + "/" + id + "?token=" + token;
        return NetworkUtils.downloadUrl(url);
    }

    public static String user(String nick, String token) throws IOException {
        String url = NICK + "/" + nick + "?token=" + token;
        return NetworkUtils.downloadUrl(url);
    }
}
