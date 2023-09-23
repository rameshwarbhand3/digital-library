export const oktaConfig = {
    clientId: '0oabgmdsz9yrXyTTX5d7',
    issuer: 'https://dev-04265973.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}