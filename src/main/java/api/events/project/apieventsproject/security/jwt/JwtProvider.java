package api.events.project.apieventsproject.security.jwt;
import api.events.project.apieventsproject.security.services.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${grokonez.app.jwtSecret}")
    private String jwtSecret;

    @Value("${grokonez.app.jwtExpiration}")
    private int jwtExpiration;

    public String generateJwtToken(Authentication authentication) {

        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

        return Jwts.builder()
		                .setSubject((userPrincipal.getUsername()))
		                .setIssuedAt(new Date())
		                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000))
		                .signWith(SignatureAlgorithm.HS512, jwtSecret)
		                .compact();
    }
    
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalido JWT assinatura -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalido JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expirado JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Nao suportado JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT esta vazio -> Message: {}", e);
        }
        
        return false;
    }
    
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(jwtSecret)
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
}