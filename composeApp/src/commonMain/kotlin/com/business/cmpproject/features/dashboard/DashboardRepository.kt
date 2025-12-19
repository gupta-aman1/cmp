import com.business.cmpproject.core.base.result.AppResult
import io.ktor.client.statement.HttpResponse

interface DashboardRepository {
    suspend fun loadDashboard(): AppResult<HttpResponse>
}
